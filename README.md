## Declarative vs Imperative UI (Jetpack Compose)
This project shows a simple declarative UI using Jetpack Compose.
The parent composable manages state with remember, and child composables receive state through parameters.
When the state changes, the UI updates automatically without manual refresh.


This project demonstrates a simple declarative UI built with Jetpack Compose.

- The parent composable owns UI state using `remember { mutableStateOf(...) }`
- Child composables are stateless and receive state via parameters
- State changes automatically trigger recomposition
- No manual UI refresh logic is used
- Includes Compose Preview
<img width="1344" height="2992" alt="Screenshot_20260203_181626" src="https://github.com/user-attachments/assets/2a443715-45a2-47d5-b94d-05d7558628f6" />

This project demonstrates the main idea of declarative UI:
the UI always reflects the current state, instead of manually updating the UI like in imperative programming.
