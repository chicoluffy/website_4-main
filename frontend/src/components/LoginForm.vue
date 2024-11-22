<template>
    <div class="page-container">
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
    export default {
        data(){
            return {
                username: '',
                password: ''
            };
        },
        methods : {
            submitForm(){
                if(this.username === 'admin' && this.password === 'admin'){
                    localStorage.setItem('auth', 'true');
                    this.$router.push('/home');
                } else {
                    alert('Invalid credentials');
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
}

h1 {
  margin-bottom: 20px; /* Espacio entre el título y el formulario */
}

.login-container {
  background-color: white;
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