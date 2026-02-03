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

This project demonstrates the main idea of declarative UI:
the UI always reflects the current state, instead of manually updating the UI like in imperative programming.
