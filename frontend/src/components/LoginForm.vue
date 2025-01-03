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
            :type="passwordVisible ? 'text' : 'password'"  
            id="password" 
            v-model="password" 
            placeholder="Password" 
            class="login-input" 
            />
            <button type="button" @click="togglePasswordVisibility" class="password-toggle-button">
              <i class="fas" :class="{ 'fa-eye-slash': passwordVisible, 'fa-eye': !passwordVisible }"></i>
            </button>
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  </div>
  <ModalComponent
    v-if="showModal"
    :title="modalTitle"
    :message="modalMessage"
    :visible="showModal"
    @close="showModal = false"
  />
</template>
<script>
  //import axios from 'axios';
  import ModalComponent from './ModelComponent.vue';
    export default {
        name: 'LoginForm',
        components: {
          ModalComponent
        },
        props: {
          isDarkMode: {
            type: Boolean,
            required: true
          }
        },
        data(){
            return {
                username: '',
                password: '',
                passwordVisible: false,
                showModal: false,
                modalTitle: '',
                modalMessage: ''
            };
        },
        methods : {
          togglePasswordVisibility() {
            this.passwordVisible = !this.passwordVisible;
          },
          submitForm()
          {
              if(this.username === 'admin' && this.password === 'admin')
              {
                  const token =  '1234567890';
                  const privileges = ['V2_EXECUTE_DEPOSIT', 'V2_EXECUTE_TRANSACTION', 'V2_EXECUTE_TRANSACTION_CREDIT', 'V2_EXECUTE_TRANSACTION_DEBIT'];
                  localStorage.setItem('token', token);
                  localStorage.setItem('privileges', JSON.stringify(privileges));
                  this.$router.push('/Division');
              }
          }
          /*async submitForm(){
              try{
                  const apiUrl = process.env.VUE_APP_API_URL;
                  console.log(apiUrl );
                  const  response = await axios.post(`${apiUrl}/Login`, {
                      username: this.username,
                      password: this.password,
                      appkey: "",
                      method: 'POST',
                      whitcredentials: true,
                      Headers: {
                          'Content-Type': 'application/json',
                           'Cache-Control': 'no-cache'
                      }
                      });
                      if(response.data && response.data.data.token && response.data.data)
                      {
                          const token = response.data.data.token;
                          const privileges = response.data.data.privilege.map(p => p.privilege_id);
                          if(privileges.length === 0){
                              this.showModal = true;
                              this.modalTitle = 'Access Denied';
                              this.modalMessage = 'You do not have access to this application';
                              return;
                          }
                          localStorage.setItem('token', token);
                          localStorage.setItem('privileges', JSON.stringify(privileges));
                          //configuramos un temporizados de inactividad
                          this.$router.push('/Division');
                      }else
                      {
                          alert('Invalid credentials');
                      }
              }catch(error){
                console.error('Error during API call:', error);
                alert('An error occurred while trying to log in.');
              }
            }*/
        },
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