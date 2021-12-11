package hoods.com.loginui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hoods.com.loginui.ui.SignUpState
import hoods.com.loginui.ui.theme.Gold
import hoods.com.loginui.ui.theme.LoginUITheme
import kotlin.math.log

@Composable
fun LoginHomeScreen() {
    LoginPageScreen()
}

@Composable
fun LandingPageScreen() {

    Surface(color = MaterialTheme.colors.primaryVariant) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    val path = Path()
                    val x = size.width
                    val y = size.height
                    val center = size.center
                    path.apply {
                        moveTo(0f, 0f)
                        lineTo(x, 0f)
                        cubicTo(
                            x1 = x,
                            y1 = center.y / 2,
                            x2 = x,
                            y2 = center.y,
                            x3 = 0f,
                            y3 = center.y

                        )

                    }

                    drawPath(path = path, color = Gold)

                }
        ) {

            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Hello",
                    style = MaterialTheme.typography.h1,
                    fontSize = 30.sp,
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Welcome to Hood Lab ",
                    style = MaterialTheme.typography.body1,
                    fontSize = 20.sp,
                    color = MaterialTheme.colors.primary
                )
                Spacer(modifier = Modifier.size(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.hood_lab_logo),
                    contentDescription = null,
                    modifier = Modifier.size(34.dp)
                )


            }

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .wrapContentSize(align = Alignment.BottomCenter)) {

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = "Sign In")
                }
                Spacer(modifier = Modifier.size(16.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onSurface
                    )
                ) {
                    Text(text = "Sign up")
                }

            }

        }
    }


}


@Composable
fun LoginPageScreen() {

    Surface(
        color = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onSurface,
    ) {
        val (username, onUserNameChange) = remember {
            mutableStateOf("")
        }
        val (password, onPasswordChange) = remember {
            mutableStateOf("")
        }
        val (checked, onCheckedChange) = remember {
            mutableStateOf(false)
        }
        Column {

            Text(
                text = "Login",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp),
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = username,
                onValueChange = onUserNameChange,
                label = { Text(text = "UserName") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_person_24),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text(text = "Password") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                shape = MaterialTheme.shapes.medium
            )
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Checkbox(checked = checked, onCheckedChange = onCheckedChange)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Remember me")
                }

                TextButton(
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "Forgot Password")
                }

            }

            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Login")
            }
        }




        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.BottomCenter)
        ) {
            Text(text = "Don't have an Account?")
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Sign Up")
            }


        }


    }


}


@Composable
fun SignUpPageScreen() {
    val signUpState = SignUpState()
    Surface(
        color = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onSurface,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp),
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)) {
                OutlinedTextField(
                    value = signUpState.firstName,
                    onValueChange = {
                        signUpState.firstNameChenged(newValue = it)
                        Log.i("SignUp", "SignUpPageScreen: $it")
                    },
                    modifier = Modifier.weight(1f),
                    shape = MaterialTheme.shapes.medium,
                    label = { Text(text = "First Name") }
                )
                Log.i("SignUp", "SignUpPageScreen: ${signUpState.firstName}")
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedTextField(
                    value = signUpState.lastName,
                    onValueChange = { signUpState.lastNameChange(it) },
                    modifier = Modifier.weight(1f),
                    shape = MaterialTheme.shapes.medium,
                    label = { Text(text = "Last Name") }
                )

            }
            OutlinedTextField(
                value = signUpState.emailAddress,
                onValueChange = { signUpState.emailAddressChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Email Address") }
            )
            Spacer(modifier = Modifier.size(8.dp))
            OutlinedTextField(
                value = signUpState.password,
                onValueChange = { signUpState.password(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            OutlinedTextField(
                value = signUpState.confirmPassword,
                onValueChange = { signUpState.confirmPasswordChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Confirm Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.size(8.dp))
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Checkbox(
                    checked = signUpState.checked,
                    onCheckedChange = { signUpState.checkedChange(it) }
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = "Agree with privacy policy")
            }
            Spacer(modifier = Modifier.size(8.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Sign Up")

            }



            Row(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .wrapContentSize(align = Alignment.BottomCenter)) {

                Text(text = "Already have an account?")
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Sign In",
                    modifier = Modifier.clickable {

                    },
                    color = MaterialTheme.colors.primary
                )


            }


        }


    }


}


@Preview(showBackground = true)
@Composable
fun LandingPagePrev() {
    LoginUITheme {
        LandingPageScreen()
    }
}














