# KUIT 8기 Android 2주차 — 주문내역 화면

쿠팡이츠 주문내역 화면을 Jetpack Compose로 만들어 보는 실습이에요.

<!-- TODO(파트장): Figma 링크를 여기에 추가하세요 -->

## 이미 들어 있는 것

- `core/ui/theme` — 지난주에 만든 `Color.kt`, `Type.kt`, `Theme.kt`
- `core/ui/BottomNavigationBar.kt` — 하단 네비게이션 바
- `res/font` — Pretendard 폰트
- `res/drawable` — 하단바 아이콘 5개 (`ic_home`, `ic_search`, `ic_favorite`, `ic_orderhistory`, `ic_profile`)
- `orderhistory/ui/component/OrderActionButton.kt` — 「같은 메뉴 담기」「바로 주문」 버튼 (그대로 가져다 써요)
- `orderhistory/ui/screen/OrderHistoryScreen.kt` — 비어 있는 화면 (여기서부터 시작해요)

## 먼저 할 일: 이미지·아이콘 가져오기

하단바 아이콘을 뺀 나머지 이미지와 아이콘은 들어 있지 않아요. Figma에서 내려받아 **아래 이름 그대로** `res/drawable`에 넣어 주세요.
코드가 이 이름으로 리소스를 찾기 때문에 철자까지 똑같아야 해요. (`ic_reciept`의 철자도 그대로예요.)
이름은 영문 소문자, 숫자, `_`만 쓸 수 있어요.

| 파일 이름 | 쓰이는 곳 |
|---|---|
| `ic_shopping_cart` | 상단바의 장바구니 |
| `ic_chevron_down` | 필터 칩 |
| `ic_reciept` | 무료배달 배너 |
| `arrow_big` | 가게 이름 옆 화살표, 무료배달 배너 |
| `ic_bungae` | 리워드 뱃지 |
| `sinjun`, `chicken`, `yupdduck`, `pizza` | 주문 카드의 가게 이미지 |

검색창의 돋보기는 이미 들어 있는 `ic_search`를 그대로 쓰면 돼요.

넣는 방법: Android Studio 왼쪽의 **Resource Manager**에서 `+` > `Import Drawables`로 파일을 가져오면, `drawable` 폴더가 없어도 자동으로 만들어져요.

## 오늘 만드는 것

`orderhistory` 패키지를 함께 만들어요.

`data class` → 더미 데이터 → 주문 카드 → 리스트 → 화면 조립

## 제출 방법

1. 이 저장소를 **Fork** 한 뒤 내 Fork를 **Clone** 해요.
2. 브랜치를 만들어요. 이름은 `본인GitHub아이디/week2` 예요. (예: `1hyok/week2`)
3. 그 브랜치에서 실습을 진행하고 **Commit → Push** 해요.
4. 원본 저장소(`Konkuk-KUIT`)에서 **Pull Request** 를 만들어요.
   `compare across forks` → head repository는 내 Fork, compare는 내 브랜치예요.
