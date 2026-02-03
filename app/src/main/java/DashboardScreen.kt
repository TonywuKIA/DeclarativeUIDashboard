package com.example.declarativeuidashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// -----------------------------
// 1) Stateful Parent Composable
// -----------------------------
@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    // owns state (Boolean + Int) using remember { mutableStateOf(...) }
    var isTracking by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    // Derived text that changes automatically when state changes
    val statusText = if (isTracking) "Tracking: ON" else "Tracking: OFF"

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Required: Text displaying a title
        Text(
            text = "Simple Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )

        // Required: Column/Row layout (here: Row)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Required: Button or Switch that changes state
            DashboardToggle(
                isOn = isTracking,
                onToggle = { isTracking = it } // lambda callback -> parent updates state
            )

            // Stateless child that triggers parent state changes via callback
            CounterControls(
                enabled = isTracking,
                counter = counter,
                onIncrement = { counter++ },
                onReset = { counter = 0 }
            )
        }

        // Required: Dynamic text that updates automatically when state changes
        StatusCard(
            status = statusText,
            counter = counter,
            isTracking = isTracking
        )
    }
}

// --------------------------------
// 2) Stateless Child Composables
// --------------------------------

// Custom composable #1 (stateless): receives state via params + callback
@Composable
fun DashboardToggle(
    isOn: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Tracking")
        Spacer(modifier = Modifier.width(8.dp))
        Switch(
            checked = isOn,
            onCheckedChange = { onToggle(it) } // notify parent
        )
    }
}

// Custom composable #2 (stateless): receives state via params + callbacks
@Composable
fun CounterControls(
    enabled: Boolean,
    counter: Int,
    onIncrement: () -> Unit,
    onReset: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(
            onClick = onIncrement,
            enabled = enabled
        ) {
            Text(text = "+1")
        }

        Spacer(modifier = Modifier.width(8.dp))

        OutlinedButton(
            onClick = onReset
        ) {
            Text(text = "Reset")
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(text = "Count: $counter")
    }
}

// Custom composable #3 (stateless): just emits UI based on state
@Composable
fun StatusCard(
    status: String,
    counter: Int,
    isTracking: Boolean
) {
    Card {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = status, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Events recorded: $counter")

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = if (isTracking)
                    "UI updates automatically when you toggle or press +1."
                else
                    "Turn tracking ON to enable +1 button."
            )
        }
    }
}

// -----------------------------
// 3) Compose Preview
// -----------------------------
@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    MaterialTheme {
        DashboardScreen()
    }
}
