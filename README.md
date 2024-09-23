# Readable Code
## 우리가 클린 코드를 추구하는 이유
### 가독성
= 코드가 잘 읽힌다.   
= 이해가 잘 된다.   
= 유지보수 하기가 수월 하다.   
= 우리의 시간과 자원이 절약 된다.   

___

### 클린 코드라 지칭하는 수 많은 원칙들, 조언들
당연히 지키면 좋은데, <span style="color: #ffd33d">**왜**</span> 지켜야 하는가?

___

### 클린 코드를 관통하는 아주 중요한 주제
추상(抽象)

___

### 프로그램
= 데이터 + 코드

___

### 추상과 구체
抽(뽑을 추), 象(코끼리 상, 형상 상)   
사물을 정확하게 이해하기 위해서 
사물이 지니고 있는 여러 가지 측면 가운데서    
특정한 측면만을 <span style="color: #ffd33d">가려내어</span> 포착하는 것이다.   
어떤 일면만을 추상하는 것은 다른 측면을 <span style="color: #ffd33d">버린다</span>는 것과 같다.

> 중요한 정보는 <span style="color: #ffd33d">가려내어</span> 남기고,    
덜 중요한 정보는 생략하여 <span style="color: #ffd33d">버린다</span>

___

### <U>추상</U>으로부터 구체를 유추하지 못한 이유   
<span style="color: #ff0000">√</span> 추상화 과정에서 중요한 정보를 부각시키지 못했다.   
→ 상대적으로 덜 중요한 정보를 남기고 중요한 정보는 제거했다. 

<span style="color: #ff0000">√</span> 해석자가 동일하게 공유하는 문맥(Context)이 없다.   
→ 중요한 정보의 기준이 다를 수 있다.
→ 즉, 도메인 영역 별 추상화 기준이 다를 수 있다.

### '잘못된 추상화'가 야기하는 side-effect는 생각보다 정말로 크다.

### '<span style="color: #ffd33d">적절한 추상화</span>'는 해당 <span style="color: #3483eb">도메인의 문맥</span> 안에서, 정말 중요한 핵심 개념만 남겨서 표시하는 것

### 이름을 짓는다.
<span style="color: #ffd33d">가장 단순하면서도, 아주 중요한, 고도의 추상적 사고 행위</span>

### <U>이름</U> 짓기 
> 단수와 복수를 구분하기

<span style="color: #ff0000">√</span> 끝에 '-(e)s'를 붙여어떤 데이터(변수, 클래스 등)가 단수인지, 복수인지 나타내는 것만으로도 읽는 이에게 중요한 정보를 같이 전달할 수 있다.

> 이름 줄이지 않기

<span style="color: #ff0000">√</span> 줄임말이라는 것은 가독성을 제물로 바쳐 효율성을 얻는 것으로, 대부분은 잃는 것에 비해 얻는 것이 적다.
<span style="color: #ff0000">√</span> 즉, 자제하는 것이 좋으나, 관용어처럼 많은 사람들이 자주 사용하는 줄임말 정도는 존재한다.   
→ ex. column -> col, latitude -> lat, longitude -> lon  
→ ex. count -> cnt(추천 X)

```java
class A {
    private int col;    
}

class TableCell {
    private int row;
    private int col;
}

class GeoPoint {
    private double lat;
    private double lon;
}
```
<span style="color: #ff0000">√</span> 자주 사용하는 줄임말이 이해될 수 있는 것은 사실 <span style="color: #ffd33d">문맥<span> 때문이다.

> 은어/방언 사용하지 않기

<span style="color: #ff0000">√</span> 농담에서 파생된 용어, 일부 팀원/현재의 우리 팀만 아는 용어 금지     
→ Q. 새로운 사람이 팀에 합류했을 때 이 용어를 단번에 이해할 수 있는가?

<span style="color: #ff0000">√</span> 도메인 용어 사용하기   
→ 도메인 용어를 먼저 정의하는 과정(ex. 도메인 용어 사전)이 먼저 필요할 수도 있다.

> 좋은 코드를 보고 습득하기

<span style="color: #ff0000">√</span> 비슷한 상황에서 자주 사용하는 단어, 개념 습득하기   
→ ex. pool, candidate, threshold 등

___

### 메서드와 추상화
잘 쓰여진 코드라면, 한 메서드의 주제는 <span style="color: #ffd33d">반드시 하나</span>다.

### 메서드 선언부
### `반환타입` <span style="color: #ffd33d">메서드명</span> (`파라미터`)

<span style="color: #ff0000">√</span> 추상화된 구체적 유추를 할 수 있는, 적절한 의미가 담긴 이름    
<span style="color: #ff0000">√</span> 파라미터와 연결지어 더 풍부한 의미를 전달할 수도 있다.


### `반환타입` `메서드명` (<span style="color: #ffd33d">파라미터</span>)

<span style="color: #ff0000">√</span> 파라미터의 타입, 개수, 순서를 통해 의미를 전달    
<span style="color: #ff0000">√</span> 파라미터는 외부 세계와 소통하는 창


### <span style="color: #ffd33d">반환타입</span> `메서드명` (`파라미터`)

<span style="color: #ff0000">√</span> 메서드 시그니처(메서드명 + 파라미터)에 납득이 가는, 적절한 타입의 반환값 돌려주기   
→ 반환 타입이 boolean인데, 이게 이 메서드에서 무엇을 의미하는거지?  
<span style="color: #ff0000">√</span> void 대신 충분히 반환할 만한 값이 있는지 고민해보기   
→ 반환값이 있따면 테스트도 용이해 진다.

___

### 추상화 레벨

### 하나의 세계 안에서는, 추상화 레벨이 동등해야 한다.

___

### 매직 넘버, 매직 스트링

<span style="color: #ff0000">√</span> 의미를 갖고 있으나, 상수로 추출되지 않은 숫자, 문자열 등     
<span style="color: #ff0000">√</span> 상수 추출로 이름을 짓고 의미를 부여함으로써 가독성, 유지보수성 ↑

___

## 논리, 사고의 흐름
### 뇌 메모리 적게 쓰기
> "정리 시스템에서 중요한 과제는 최소의 인지적 노력으로 최대의 정보를 제공하는 것이다."

대니얼 J.레비틴, -정리하는 뇌-

> 뇌는 한 번에 한 가지 일 밖에 하지 못한다. 멀티태스킹? 그건 저글링일 뿐.

요한 하리, -도둑맞은 집중력

### Early return
```java
if (a > 3) {
    doSomething1();
} else if (a <= 3 && b > 1) {
    doSomething2();
} else {
    doSomething3();    
}

// method 추출 밑 early return 적용 == 뇌 메모리 적게 쓰기
extracted();

void extracted() {
    if (a > 3) {
        doSomething1();
        return;
    }
    
    if (a <= 3 && b > 1) {
        doSomething2();
        return;
    }
    
    doSomething3();
}
```
### 사고의 depth 줄이기
* 중첩 분기문, 중첩 반복문    
  <span style="color: #ff0000">√</span> '무조건 1 depth로 만들어라'가 아니다.   
→ 보이는 depth를 줄이는데 급급한 것이 아니라, 추상화를 통한 <span style="color: #ffd33d">사고 과정의 depth</span>를 줄이는것이 중요    
→ 2중 중첩 구조로 표현하는 것이 사고하는 데에 더 도움이 된다고 판단한다면, 메서드 분리보다 그대로 놔두는 것이 더 나은 선택일 수 있다. 때로는 메서드를 분리하는 것이 더 혼선을 줄 수도 있다.


* 사용할 변수는 가깝게 선언하기

### 공백 라인을 대하는 자세
<span style="color: #ff0000">√</span> 공백 라인도 의미를 가진다.   
→ 복잡한 로직의 의미 단위를 나누어 보여줌으로써 읽는 사람에게 추가적인 정보를 전달할 수 있다.

### 부정어를 대하는 자세
<span style="color: #ff0000">√</span> 부정어구를 쓰지 않아도 되는 상황인지 체크   
<span style="color: #ff0000">√</span> 부정어의 의미를 담은 다른 단어가 존재하는지 고민하기 or 부정어구로 메서드명 구성    
→ 부정연산자(!)의 가독성 ↓

### 해피 케이스와 예외 처리
<span style="color: #ff0000">√</span> 예외가 발생할 가능성 낮추기   
<span style="color: #ff0000">√</span> 어떤 값의 검증이 필요한 부분은 주로 외부 세계와의 접점   
→ 사용자 입력, 객체 생성자, 외부 서버의 요청 등   
<span style="color: #ff0000">√</span> 의도한 예외와 예상하지 못한 예외를 구분하기  
→ 사용자에게 보여줄 예외와, 개발자가 보고 처리해야 할 예외 구분

### Null을 대하는 자세
<span style="color: #ff0000">√</span> 항상 NullPointException을 방지하는 방향으로 경각심 가지기  
<span style="color: #ff0000">√</span> 메서드 설계 시 retrun null을 자제한다.       
→ 만약 어렵다면, Optional 사용을 고민해 본다.     
<span style="color: #ff0000">√</span> Optional에 관하여 
→ Optional은 비싼 객체다. 꼭 필요한 상황에서 반환 타입에 사용한다.     
→ Optional은 파라미터로 받지 않도록 한다. 분기 케이스가 3개나 된다. (optional이 가진 데이터가 null인지 아닌지 + optional 그 자체가 null)   
→ Optional을 반환 받았다면 최대한 빠르게 해소한다.   
<span style="color: #ff0000">√</span> Optional을 해소하는 방법     
→ 분기문을 만드는 isPresent()-get() 대신 풍부한 API 사용      
ex) orElseGet(), orElseThrow(), ifPresent(), ifPresentOrElse()      
→ orElse(), orElseGet(), orElseThrow()의 차이 숙지   
orElse(): 항상 실행, 확정된 값일 때 사용    
orElseGet(): null인 경우 실행, 값을 제공하는 동작(supplier) 정의