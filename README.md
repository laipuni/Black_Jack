## 🎨 기능 구현

카드 52장을 만들어야한다.
플레이어들의 이름을 입력받는다.

->플레이어들의 이름들 중 중복이 없는지 확인한다.

->플레이어들의 이름들 중 "딜러"와 같은 이름이 없는지 확인한다.

->플레이어는 1~7명까지 참여가능하다.

->플레이어 이름은 1자~20자까지 가능하다.

->플레이어 이름은 공백이나 null일 수 없다.

위 사항이 발생시 예외를 발생 시킨다.

각각의 플레이어들은 배팅금액을 입력한다.

->배팅금액은 1,000원 이상에서 100,000,000이하이다.

카드 2장씩 딜러와 플레이어에게 나눠줘야한다.

딜러가 받은 2장의 카드가 블랙잭인지 확인한다.

2장을 받은 플레이어들중 블랙잭을 가진 플레이어를 찾는다.

딜러가 블랙잭을 가지고, 플레이어들 중 블랙잭이 없는 플레이어는 배팅 금액을 잃는다.

플레이어들중 블랙잭을 가지고 있는 플레이어는 배팅금액의 1.5배를 받는다.

딜러는 2장의 카드중 1장의 카드를 은폐하고, 나머지 1장을 공개한다.

각 플레이어들은 카드를 공개한다.

카드는 숫자 A,2,3,4,5,6,7,8,9,10,k,j,q이 있고, 타입은 스페이드,하트,클로버,다이아몬드가 있다.

숫자 A는 1 혹은 10으로 계산한다.

각각의 플레이어들이 버스트(21초과)인지 확인한다.

버스트한 플레이어가 존재할 경우 플레이어들의 패이다.

버스트하지 않은 플레이어는 카드 한 장을 뽑을 지 입력한다.(y or n)

딜러가 버스트일 경우 버스트하지 않은 플레이어들은 배팅금액을 1.5배로 받는다.(승리한다.)

딜러는 16이하 일 경우는 카드한장을 뽑고, 17이상일 경우 뽑지 않는다.

딜러는 지금까지 받은 카드를 전부 보여주고 점수를 보여준다

플레이어들은 지금까지 받은 카드를 전부 보여주고 점수를 보여준다.

딜러와 플레이어를 비교해서 21점에 가까운 사람이 승리한다.

### 역할
카드 덱
- 카드 52장을 생성
- 카드를 한장 뽑아 준다.

카드
- A,1~10,k,j,q 카드가 있다.
- 스페이드, 하트 ,클로버, 다이아몬드의 카드타입이 있다.

딜러
- 카드를 가지고 있는다.
- 카드를 뽑는다.
- 가지고 있는 카드를 보여준다.
- 블랙잭인지 확인한다.
- 버스트인지 확인한다.

플레이어
- 카드를 가지고 있는다.
- 카드를 뽑는다.
- 가지고 있는 카드를 보여준다.
- 블랙잭인지 확인한다.
- 버스트인지 확인한다.
