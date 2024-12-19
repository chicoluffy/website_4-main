
<template>
  <div :class="['login-page',{'dark-mode': isDarkMode}]">
    <div class="header">
      <SwitchBtn :is-dark-mode="isDarkMode" class="switch-btn" />
    </div>
    <div class="content">
      <LoginForm class="login-form" />
    </div>
  </div>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue';
import SwitchBtn from '@/components/SwitchBtn.vue';
import EventBus from '@/eventBus/eventBus';

export default {
  name: 'LoginPage',
  beforeRouteEnter(to,from,next){
    if(from.name == 'DivisionPage'){
      localStorage.removeItem('auth');
    }
    next();
  },
  components: {
    LoginForm,
    SwitchBtn,
  },
  data (){
    return {
      isDarkMode: localStorage.getItem('dark-mode') === 'true' || (window.matchMedia('(prefers-color-scheme: dark)').matches)
    };
  },
  mounted(){
    EventBus.on('toggle-dark-mode', (isDarkMode) => {
      this.isDarkMode = isDarkMode;
    });
  },
};
</script>

<style scoped>
.header {
    width: 100%;
    display: flex;
    justify-content: flex-end;
    padding: 1rem;
}

.content {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex: 1;
}
  .login-page {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    transition: background-color 0.3s;
    position: relative;
  }
  .login-page.dark-mode {
    background-color: #192229;
    color: #52A5E0;
  }
  .login-page:not(.dark-mode){
    background-color: #FBFBFE;
    color: #2A3B47;
  }
 
  .switch-btn {
  position: absolute;
  top: 20px;
  right: 20px;
}
</style>