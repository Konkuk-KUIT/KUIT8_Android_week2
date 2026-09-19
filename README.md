# KUIT 8기 Android 2주차 — 주문내역 화면

쿠팡이츠 주문내역 화면을 Jetpack Compose로 만들어 보는 실습이에요.

<!-- TODO(파트장): Figma 링크를 여기에 추가하세요 -->

## 이미 들어 있는 것

- `core/ui/theme` — 지난주에 만든 `Color.kt`, `Type.kt`, `Theme.kt`
- `core/ui/BottomNavigationBar.kt` — 하단 네비게이션 바
- `res/font` — Pretendard 폰트
- `res/drawable` — 하단바 아이콘 5개 (`ic_home`, `ic_search`, `ic_favorite`, `ic_orderhistory`, `ic_profile`)
- `orderhistory/ui/component/OrderActionButton.kt` — 「같은 메뉴 담기」「바로 주문」 버튼
- `orderhistory/ui/screen/OrderHistoryScreen.kt` — 비어 있는 화면 

## 실습 내용

`orderhistory` 패키지를 함께 만들어요.

`data class` → 더미 데이터 → 주문 카드 → 리스트 → 화면 조립

## 미션 내용

장바구니 화면 구현
