<template>
    <div :class="['page-container', { 'dark-mode': isDarkMode }]">
    <h1>Finance System</h1>
    <div class="login-container">
      <form class="login-form" @submit.prevent="submitForm">
        <div class="input-group">
          <input 
            type="text" 
            id="username" 
            v-model="username" 
            placeholder="User" 
            class="login-input" 
          />
          <input 
            type="password" 
            id="password" 
            v-model="password" 
            placeholder="Password" 
            class="login-input" 
          />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  </div>
</template>
<script>
  import axios from 'axios';
    export default {
        name: 'LoginForm',
        props: {
          isDarkMode: {
            type: Boolean,
            required: true
          }
        },
        data(){
            return {
                username: '',
                password: ''
            };
        },
        methods : {
            async submitForm(){
                try{
                    const apiUrl = process.env.VUE_APP_API_URL;
                    const  response = await axios.post(`${apiUrl}/validate`, {
                        username: this.username,
                        password: this.password,
                        token: '123456',
                        method: 'POST',});
                    if(!response.data){
                      alert('Invalid credentials');
                    }
                    localStorage.setItem('auth', 'true');
                    this.$router.push('/home');
                }catch(error){
                    console.error(error);
                    alert('An error occurred', error);
                }
            }
        }
    };
</script>
<style>
body {
  background-color: #f5f5f5;
  margin: 0;
  overflow: hidden; /* Eliminar scroll vertical */
}

.page-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh; /* Altura completa de la ventana */
  transition: background-color 0.3s;
}


h1 {
  margin-bottom: 20px; /* Espacio entre el título y el formulario */
}

.login-container {
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.login-form {
  display: flex;
  flex-direction: column;
}

.input-group {
  margin-bottom: 15px;
}

.login-input {
  border: none;
  border-bottom: 2px solid #ccc;
  background: transparent;
  outline: none;
  padding: 10px;
  font-size: 16px;
  flex: 1; /* Para que los inputs ocupen el mismo tamaño */
  text-align: center;
  margin-bottom: 10px;
  gap: 20px;
}
.login-input:focus {
  border-bottom-color: #007bff;
  transition: border-bottom-color 0.3s;
}
.login-input::placeholder {
  color: #aaa;
  text-align: center;
}

button {
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style> 