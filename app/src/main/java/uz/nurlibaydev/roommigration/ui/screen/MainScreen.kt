package uz.nurlibaydev.roommigration.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.nurlibaydev.roommigration.database.model.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val name = remember {
        mutableStateOf("")
    }
    val age = remember {
        mutableStateOf("")
    }
    val list = viewModel.users.value

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(list.size) {
                UserItem(user = list[it])
            }
        }
        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            placeholder = { Text("Enter name") }
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = age.value,
            onValueChange = {
                age.value = it
            },
            placeholder = { Text("Enter age") }
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(
            onClick = {
                viewModel.insertUser(
                    User(id = 0, name = name.value, userAge = age.value.toInt())
                )
                name.value = ""
                age.value = ""
            }

        ) {
            Text(text = "Save User")
        }
    }
}

@Composable
fun UserItem(
    user: User
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "id: ${user.id}",
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "name: ${user.name}",
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "age: ${user.userAge}",
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
}