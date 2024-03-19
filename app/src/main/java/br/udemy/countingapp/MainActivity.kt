package br.udemy.countingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.udemy.countingapp.ui.theme.CountingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CounterViewModel = viewModel()

            CountingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterMVVMApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun CounterMVVMApp(viewModel: CounterViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { viewModel.decrement() }) {
            Text(text = "   -   ")
        }
        Text(
            text = viewModel.getCount().toString(),
            style = MaterialTheme.typography.headlineSmall,
        )
        Button(onClick = { viewModel.increment() }) {
            Text(text = "   +  ")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    val viewModel: CounterViewModel = viewModel()
    CountingAppTheme {
        CounterMVVMApp(viewModel)
    }
}