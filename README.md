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

---
## 객체 지향 패러다임
### 추상의 관점으로 바라보는 객체 지향

객체: 추상화된 [데이터 + 코드]   
객체간의 협력과 객체가 담당하는 책임    
관심사의 분리 - 높은 응집도, 낮은 결합도    

### 객체 설계하기
> 객체로 추상화하기

<span style="color: #ff0000">√</span> 비공개 필드(데이터), 비공개 로직(코드)   
<span style="color: #ff0000">√</span> 공개 메서드 선언부를 통해 외부 세계와 소통    
→ 각 메서드의 기능은 객체의 책임을 드러내는 창구     
<span style="color: #ff0000">√</span> 객체의 책임이 나뉨에 따라 객체 간 협력이 발생

> 객체가 제공하는 것

<span style="color: #ff0000">√</span> 절차 지향에서 잘 보이지 않았던 개념을 가시화
<span style="color: #ff0000">√</span> 관심사가 한 군데로 모이기 때문에, 유지 보수성 ↑  
→ ex) 객체 내부에서 객체가 가진 데이터의 유효성 검증 책임을 가질 수 있다.   
<span style="color: #ff0000">√</span> 여러 객체를 사용하는 입장에서는, 구체적인 구현에 신경쓰지 않고 보다 높은 추상화 레벨에서 도메인 로직을 다룰 수 있다.   

> 새로운 객체를 만들 때 주의할 점

<span style="color: #ff0000">√</span> 1개의 관심사로 명확하게 책임이 정의되었는지 확인하기   
→ 메서드를 추상화할 때와 비슷하다.    
→ 객체를 만듦으로써 외부 세계와 어떤 소통을 하려고 하는지 생각해보자.   

<span style="color: #ff0000">√</span> 생성자, 정적 팩토리 메서드에서 유효성 검증이 가능하다.   
→ 도메인에 특화된 검증 로직이 들어갈 수 있다.   
```java
class Money {
    private long value;
    
    public Money(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("돈은 0원 이상이어야 합니다.");
        }
    }
}
```
<span style="color: #ff0000">√</span> setter 사용 자제  
→ 데이터는 불변이 최고다. 변하는 데이터라도 객체가 핸들링할 수 있어야 한다.   
→ 객체 내부에서 외부 세계의 개입 없이 자체적인 변경/가공으로 처리할 수 있는지를 확인   
→ 만약 외부에서 가지고 있는 데이터로 데이터 변경 요청을 해야하는 경우, `set~`이라는 단순한 이름 보다는 `update~`같이 의도를 드러내는 네이밍을 고려하자.  

<span style="color: #ff0000">√</span> getter도 처음에는 사용 자제. 반디스 필요한 경우에 추가하기  
→ 외부에서 객체 내 데이터가 필요하다고 getter를 남발하는 것은 무례한 행동이다.  
<span style="color: #ff0000">√</span> 객체에 메세지를 보내라!
```java
Person person = new Person();

// (1)
if (person.get지갑().get신분증().findAge() >= 19) {
    pass();    
}

// (2)
if (person.isAgeGreaterThanOrEqualTo(19)) {
    pass();
}
```
<span style="color: #ff0000">√</span> 필드의 수는 적을 수록 좋다.    
→ 불필요한 데이터가 많을 수록 복잡도가 높아지고 대응할 변화가 많아진다.   
→ 필드 A를 가지고 계산할 수 있는 A'필드가 있다면 메서드 기능으로 제공  
→ 단, 미리 가공하는 것이 성능 상 이점이 있다면, 필드로 가지고 있는 것이 좋을 수 도 있다.    
```java
class Bill {
    private final List<Menu> menus;
    // menus를 통해 계산할 수 있는 값
    private final long totalPrice;
    
    // 필드 대신 제공할 수 있는 기능
    public long calculateTotalPrice() {
        return this.menus.stream()
                .mapToLong(Menu::getPrice)
                .sum();
    }  
}
```
### SRP: Single Responsibility Principle
<span style="color: #ff0000">√</span> 하나의 클래스는 단 한 가지의 변경 이유만을 가져야 한다.    
→ '변경 이유' = 책임   

<span style="color: #ff0000">√</span> 객체가 가진 공개 메서드, 필드, 상수 등은 해당 객체의 단일 책임에 의해서만 변경 되는가?    

<span style="color: #ff0000">√</span> 관심사의 분리

<span style="color: #ff0000">√</span> 높은 응집도, 낮은 결합도    

### OCP: Open-Closed Principle
<span style="color: #ff0000">√</span> 확장에는 열려 있고, 수정에는 닫혀 있어야 한다.    
→ 기존 코드의 변경 없이, 시스템의 기능을 확장할 수 있어야 한다.   

<span style="color: #ff0000">√</span> 추상화와 다영형을 활용해서 OCP를 지킬 수 있다.    

### LSP: Liskov Substitution Principle
<span style="color: #ff0000">√</span> 상속 구조에서, 부모 클래스의 인스턴스를 자식 클래스의 인스턴스로 치환할 수 있어야 한다.  
→ 자식 클래스는 부모 클래스의 책임을 준수하며, 부모 클래스의 행동을 변경하지 않아야 한다.  

<span style="color: #ff0000">√</span> LSP를 위반하면, 상속 클래스를 사용할 때 오동작, 예상 밖의 예외가 발생하거나, 이를 방지하기 위한 불필요한 타입 체크가 동반될 수 있다.  

### ISP: Interface Segregation Principle
<span style="color: #ff0000">√</span> 클라이언트는 자신이 사용하지 않는 인터페이스에 의존하면 안 된다.  
→ 인터페이스를 잘게 쪼개라!

<span style="color: #ff0000">√</span> ISP를 위반하면, 불필요한 의존성으로 인해 결합도가 높아지고, 특정 기능의 변경이 여러 클래스에 영향을 미칠 수 있다.  

### DIP: Dependency Inversion Principle
<span style="color: #ff0000">√</span> 상위 수준의 모듈은 하위 수준의 모듈에 의존해서는 안된다. 둘 모두 추상화에 의존해야 한다.  

<span style="color: #ff0000">√</span> 의존성의 순방향: 고수준 모듈이 저수준 모듈을 참조하는 것.   
<span style="color: #ff0000">√</span> 의존성의 역향: 고수준, 저수준 모듈이 모두 추상화에 의존하는 것.   
→ 저수준 모듈이 변경되어도, 고수준 모듈에는 영향이 가지 않는다.   

---
## 객체 지향 적용하기
### 상속과 조합
<span style="color: #ff0000">√</span> 상속보다 조합을 사용하자.   
<span style="color: #ff0000">√</span> 상속은 시멘트처럼 굳어지는 구조다. 수정이 어렵다.   
→ 부모와 자식의 결합도가 높다.   

<span style="color: #ff0000">√</span> 조합과 인터페이스를 활용하는 것이 유연한 구조.   
→ 상속을 통한 코드의 중복 제거가 주는 이점보다, 중복이 생기더라도 유연한 구조 설계가 주는 이점이 더 크다.  

### Value Object
<span style="color: #ff0000">√</span> 도메인의 어떤 개념을 추상화하여 표현한 값 객체.   

<span style="color: #ff0000">√</span> 값으로 취급하기 위해서, 불변성, 동등성, 유효성 검증 등을 보장해야 한다.   
→ 불변성: final 필드선언 및 setter 금지   
→ 동등성: 서로 다른 인스턴스여도(동일성이 달라도), 내부의 값이 같으면 같은 값 객체로 취급한다. `equals()` & `hashCode()` 재정의 필요.    
→ 유효성 검증: 객체가 생성되는 시점에 값에 대한 유효성을 보장하기    

#### VO vs Entity
<span style="color: #ff0000">√</span> Entity는 식별자가 존재한다. 식별자가 아닌 필드의 값이 달라도, 식별자가 같으면 동등한 객체로 취급한다.   
→ `equals()` & `hashCode()`도 식별자 필드만 가지고 재정의 할 수 있다.    
→ 식별자가 같은데 식별자가 아닌 필드의 값이 서로 다른 두 인스턴스가 있다면, 같은 Entity가 시간이 지남에 따라 변화한 것으로 이해할 수도 있다.   

<span style="color: #ff0000">√</span> VO는 식별자 없이, 내부의 모든 값이 다 같아야 동등한 객체로 취급한다.   
→ 개념적으로, 전체 필드가 다같이 식별자 역할을 한다고 생각해도 된다.      

### 일급 컬렉션
#### 일급 시민
<span style="color: #ff0000">√</span> 다른 요소에게 사용 가능한 모든 연산을 지원하는 요소.   
→ 변수로 할당될 수 있다.
→ 파라미터로 전달될 수 있다.    
→ 함수의 결과로 반환될 수 있다.

ex) 일급 함수
함수형 프로그래밍 언어에서, 함수는 일급 시민이다.  
함수는 변수에 할당될 수 있고, 인자로 전달될 수 있고,   
함수의 결과로 함수가 반환될 수도 있다.  

#### 일급 컬렉션
<span style="color: #ff0000">√</span> 컬렉션을 포장하면서, 컬렉션만을 유일하게 필드로 가지는 객체.   
→ 컬렉션을 다른 객체와 동등한 레벨로 다루기 위함.
→ 단 하나의 컬렉션 필드만을 가진다.    

<span style="color: #ff0000">√</span> 컬렉션을 추상화하며 의미를 담을 수 있고, 가공 로직의 보금자리가 생긴다.   
→ 가공 로직에 대한 테스트도 작성할 수 있다.    

<span style="color: #ff0000">√</span> 만약 getter로 컬렉션을 반환할 일이 생긴다면, 외부 조작을 피하기 위해 꼭 새로운 컬렉션으로 만들어서 반환해주자.    

### Enum
<span style="color: #ff0000">√</span> Enum은 상수의 집합이며, 상수와 관련된 로직을 담을 수 있는 공간이다.   
→ 상태와 행위를 한 곳에서 관리할 수 있는 추상화된 객체.

<span style="color: #ff0000">√</span> 특정 도메인 개념에 대해 그 종류와 기능을 명시적으로 표현해줄 수 있다.

<span style="color: #ff0000">√</span> 만약 변경이 정말 잦은 개념은, Enum 보다 DB로 관리하는 것이 나을 수 있다.   

### 다형성 활용하기
```java
CellSnapshotstatus status = cellSnapshot.getStatus();

if (status == CellSnapshotStatus.EMPTY) {
    return EMPTY_SIGN;
}

if (status == CellSnapshotStatus.FLAG) {
    return FLAG_SIGN;
}

if (status == CellSnapshotStatus.LANDMINE) {
    return LAND_MINE_SIGN;
}

if (status == CellSnapshotStatus.NUMBER) {
    return String.valueOf(snapshot.getNearbyLandMineCount());
}

if (status == CellSnapshotStatus.UNCHECKED) {
    return UNCHECKED_SIGN;
}

throw new IllegalStateException("Unexpected cell snapshot status: " + status);
```
'어떤 조건을 만족하면, 그 조건을 해당하는 행위를 수행한다' 반복되고 있음

OCP
* 변화하는 것: 조건 & 행위 -> 구체
* 변화하지 않는것: 1. 조건을 만족하는가? 2. 행위를 수행한다. -> 추상

`CellSignProvidable` -> 제공해줄 수있는 정보들 정의   
`CellSignFinder` -> 만족하는 조건을 찾아서 행위를 수행한다.

### 숨겨져있는 도메인 개념 도출하기
<span style="color: #ff0000">√</span> 도메인 지식은 만드는 것이 아니라 발견하는 것   

<span style="color: #ff0000">√</span> 객체 지향은 현실을 100% 반영하는 도구가 아니라, 흉내내는 것이다.    
→ 현실 세계에서 쉽게 인지하지 못하는 개념도 도출해서 사용해야 할 때가 있다.  

<span style="color: #ff0000">√</span> 설계할 때는 근시적, 거시적 관점에서 최대한 미래를 예측하고,    
시간이 지나 만약 틀렸다는 것을 인지하면 언제든 돌아올 수 있도록 코드를 만들어야 한다.   
→ 완벽한 설계는 없다. 그 당시의 최선이 있을 뿐.  
---
## 코드 다듬기
### 주석의 양면성
<span style="color: #ff0000">√</span> 주석이 많다는 것은, 그만큼 비즈니스 요구사항을 코드에 잘 못 녹였다는 이야기.      

<span style="color: #ff0000">√</span> 코드를 설명하는 주석을 쓰면, 코드가 아니라 주석에 의존한다.    
주석에 의존하여 코드를 작성하면, 적절하지 않은 추상화 레벨을 갖게 되어 낮은 품질의 코드가 만들어진다.  

<span style="color: #ff0000">√</span> 주석을 작성할 때, 자주 변하는 정보는 최대한 지양해서 작성한다.

<span style="color: #ff0000">√</span> 만약 관련 정책이 변경하거나 코드가 변경되었다면, 주석도 잊지 않고 함께 업데이트 한다.   
주석이 없는 코드보다, 부정확한 주석이 달린 코드가 더 치명적이다.

### 좋은 주석
<span style="color: #ff0000">√</span> 우리가 리팩토링할 때, 정말 큰 난관중 하나는 히스토리를 전혀 알 수 없는 코드다.    

<span style="color: #ff0000">√</span> 후대에 전해야 할 "의사 결정의 히스토리"를 도저히 코드로 표현할 수 없을 때, 주석으로 상세하게 설명한다.
```java
/**
 * 이 객체가 가지고 있는 정책은,
 * A안과 B안 중 AB테스트를 통해 결정된 사항을 기반으로 작성된 것이다.
 * 관련 문서 https://wiki.readable-code.com?pageId=123
 */
public class SpecificPolicy { ... }
```
<span style="color: #ff0000">√</span> 우리가 가진 모든 표현 방법을 총동원해 코드에 의도를 녹여내고,   
그럼에도 불구하고 전달해야할 정보가 남았을 때 사용하는 주석.    

### 변수와 메서드의 나열 순서
<span style="color: #ff0000">√</span> 변수는 사용하는 순서대로 나열 한다.   
→ 인지적 경제성  

<span style="color: #ff0000">√</span> 메서드의 순서도 고려해보아야 하는데, 객체의 입장에서 생각해보자.    
```java
public method1() {
    method1-1();
    method1-2();
}

private method1-1() {..}
private method1-2() {..}

public method2() {
  method2-1();
  method2-2();
}

private method2-1() {..}
private method2-2() {..}
```

```java
public method1() {
    method1-1();
    method1-2();
}

public method2() {
  method2-1();
  method2-2();
}

private method1-1() {..}
private method1-2() {..}
private method2-1() {..}
private method2-2() {..}
```

<span style="color: #ff0000">√</span> 객체는 협력을 위한 존재이다. 외부 세계에 내가 어떤 기능을 제공할 수 있는지를 드러낸다.    
(정해진 답은 아니지만) 공개 메서드를 상단에 배치하는 것을 선호하는 편.

<span style="color: #ff0000">√</span> 공개 메서드끼리도 기준을 가지고 배치하는 것이 좋다.   
→ 객체 지향을 하다보면 중요 객체의 경우 메서드가 수십개까지도 늘어날 수 있는데,  
중요도 순, 종류별로 그룹화하여 배치하면 실수로 비슷한 로직의 메서드를 중복으로 만든 것을 방지하고,   
일관성 있는 로직을 유지할 수있다.  
→ 상태 변경 >> 판별 >= 조회 메서드  

<span style="color: #ff0000">√</span> 비공개 메서드는, 공개 메서드에서 언급된 순서대로 배치한다.   

<span style="color: #ff0000">√</span> 공통으로 사용하는 메서드라면, (가장 하단과 같은) 적당한 곳에 배치한다.   

중요한 것은, 나열 순서로도 의도와 정보를 전달 할 수 있다는 것.

## 패키지 나누기
<span style="color: #ff0000">√</span> 패키지는, 문맥으로써의 정보를 제공할 수 있다.    
→ Beginner, Middle, Advanced가 BeginnerGameLevel, MiddleGameLevel, AdvancedGameLevel이 아니어도 괜찮은 이유중 하나는, gamelevel 패키지 안에 있기 때문이다.  

<span style="color: #ff0000">√</span> 패키지를 쪼개지 않으면 관리가 어려워 진다.

<span style="color: #ff0000">√</span> 패키지를 너무 잘게 쪼개도 마찬가지로 관리가 어려워진다.

<span style="color: #ff0000">√</span> 대규모 패키지 변경은 팀원과 합의를 이룬 시점에 하자.    
→ 현재 기준으로 본인만 변경하고 있는 부분이라면 괘찮으나, 여러 사람이 변경 중인 부분이나, 공통으로 사용하는 클래스들의 패키지를 한번에 변경하면, 추후 conflict가 생길 수 있다.   
→ 처음 만들 때부터 잘 고민해서 패키지를 나눠놓는 것이 제일 좋다.     

### IDE의 도움 받기
<span style="color: #ff0000">√</span> 코드 포맷 정렬: mac: `option` + `cmd` + `L` | win: `ctr` + `alt` + `L`  

<span style="color: #ff0000">√</span> 코드 품질: Sonarlint
→ lint(linting): 잠재적인 문제가 될 수 있는 오류, 버그, 스타일 등을 미리 알려주는 코드 품질 체크 도구 (ex. 코틀린 - ktlint)    

<span style="color: #ff0000">√</span> 포맷 규칙: .editorconfig    
→ 여러 사람과 협업을 염두하면 IDE 기본 포맷팅에 익숙해지는 것이 좋다.    
→ 스타일은 혼자 결정하는 것이 아니라, 팀 내 합의로 도출되어야만 한다.   
→ 한 번 정해지면 절대적인 것이 아니라, 사용하면서 계속 의견을 듣고 개선/반영하는 것이 좋다.    
---
## 기억하면 좋은 조언들
### 능동적 읽기
<span style="color: #ff0000">√</span> 복잡하거나 엉망인 코드를 읽고 이해하려 할 때, 리팩토링하면서 읽기   
→ 공백으로 단락 구분하기
→ 메서드와 객체로 추상화 해보기
→ 주석으로 이해한 내용 표기하며 읽기

<span style="color: #ff0000">√</span> 우리에게는 언제든지 돌아갈 수 있는 git reset --hard 가 있다.

<span style="color: #ff0000">√</span> 핵심 목표는 우리의 도메인 지식을 늘리는 것. 그리고 이전 작성자의 의도를 파악하는 것.

### 오버 엔지니어링
<span style="color: #ff0000">√</span> 필요한 적정 수준보다 더 높은 수준의 엔지니어링.   
→ ex) 구현체가 하나인 인터페이스

- 인터페이스 형태가 아키텍처 이해에 도움을 주거나, 근시일 내에 구현채가 추가될 가능성이 높다면 OK.
- 구현체를 수정할 때마다 인터페이스도 수정해야함
- 코드 탐색에 영향을 줌. 애플리케이션이 비대해 짐.    

→ ex) 너무 이른 추상화

- 정보가 숨겨지기 때문에 복잡도가 높아진다.
- 후대 개발자들이 선대의 의도를 파악하기 어렵다.

### 은탄환은 없다
>한번은 개발자와 체스를 구현하는 방법에 대해 논의한 적이 있습니다.   
나는 그가 어떻게 할 것인지 물었습니다.  
객체 지향 프로그래밍에 정통한 그는 
"인터페이스와 클래스를 사용한다"고 답했습니다.    
나는 "하드코딩하는 편이 더 쉽지 않을까요?"라고 운을 띄웠습니다.   
그는 "물론이죠. 하지만 잘 유지보수 하시기 바랍니다." 라고 말하면서 내가 농담을 한 것처럼 씩 웃었습니다.   
"체스는 지난 500년 동안 변하지 않았습니다." 내 말에 그 의 눈이 커졌습니다.
- 크리스찬 클라우젠, '파이브 라인스 오브 코드'

---
<span style="color: #ff0000">√</span> 클린 코드도 은탄환이 아니다.    

<span style="color: #ff0000">√</span> 실무: 2가지 사이의 줄다리기.   
→ 지속 가능한 소프트웨어의 품질 VS 기술 부채를 안고 가는 빠른 결과물   
→ 대부분의 회사는 돈을 벌고 성장해야 하고, 시장에서 빠르게 살아남는 것이 목표다.   
→ 이런 경우에도, 클린 코드를 추구하지 말라는 것이 아니라, 미래 시점에 잘 고치도록 할 수 있는 코드 센스가 필요하다. 결국은, 클린 코드의 사고법을 기반으로 결정하는 것.    

<span style="color: #ff0000">√</span> 모든 기술과 방법론은 적정 기술의 범위 내에서 사용되어야 한다.   
→ 당장 급하게 배포 나가야 하는데, 동료에게 style 관련된 리뷰를 주고 고치도록 강요하는 사람   

<span style="color: #ff0000">√</span> 도구라는 것은, 일단 그것을 한계까지 사용할 줄 아는 사람이 그것을 사용하지 말아야 할 때도 아는 법이다.   
→ 적정 수준을 알기 위해, 때로는 극단적으로 시도해보자.