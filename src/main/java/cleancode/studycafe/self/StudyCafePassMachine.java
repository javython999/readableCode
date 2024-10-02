package cleancode.studycafe.self;

import cleancode.studycafe.self.exception.AppException;
import cleancode.studycafe.self.io.InputHandler;
import cleancode.studycafe.self.io.IoHandler;
import cleancode.studycafe.self.io.OutputHandler;
import cleancode.studycafe.self.io.StudyCafeFileHandler;
import cleancode.studycafe.self.model.StudyCafeLockerPass;
import cleancode.studycafe.self.model.StudyCafePass;
import cleancode.studycafe.self.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final IoHandler ioHandler = new IoHandler();
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        try {
            ioHandler.showWelcomeMessage();
            ioHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();

            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

            List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();

            List<StudyCafePass> passesCandidates = getStudyCafeSeatPassesBy(studyCafePasses, studyCafePassType);

            outputHandler.showPassListForSelection(passesCandidates);
            StudyCafePass selectedPass = inputHandler.getSelectPass(passesCandidates);


            if (studyCafePassType == StudyCafePassType.HOURLY || studyCafePassType == StudyCafePassType.WEEKLY) {

                outputHandler.showPassOrderSummary(selectedPass, null);
            } else if (studyCafePassType == StudyCafePassType.FIXED) {

                StudyCafeLockerPass lockerPass = getStudyCafeLockerPassBy(studyCafeFileHandler, selectedPass);

                boolean lockerSelection = false;
                if (lockerPass != null) {
                    outputHandler.askLockerPass(lockerPass);
                    lockerSelection = inputHandler.getLockerSelection();
                }

                if (lockerSelection) {
                    outputHandler.showPassOrderSummary(selectedPass, lockerPass);
                } else {
                    outputHandler.showPassOrderSummary(selectedPass, null);
                }
            }
        } catch (AppException e) {
            ioHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            ioHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private static List<StudyCafePass> getStudyCafeSeatPassesBy(List<StudyCafePass> studyCafePasses, StudyCafePassType studyCafePassType) {
        return studyCafePasses.stream()
                .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
                .toList();
    }

    private static StudyCafeLockerPass getStudyCafeLockerPassBy(StudyCafeFileHandler studyCafeFileHandler, StudyCafePass selectedPass) {
        List<StudyCafeLockerPass> lockerPasses = studyCafeFileHandler.readLockerPasses();
        return lockerPasses.stream()
                .filter(option ->
                    option.getPassType() == selectedPass.getPassType()
                    && option.getDuration() == selectedPass.getDuration()
                )
                .findFirst()
                .orElse(null);
    }

}
