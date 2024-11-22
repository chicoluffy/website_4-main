<template>
    <div :class= "['home-page',{'dark-mode':isDarkMode}]">
        <NavBar :isDarkMode="isDarkMode"/>
        <div class="main-content">
          <SidebarComponent :isDarkMode="isDarkMode" />
          <div class="content">
            <h1>Welcome, {{ userName }}</h1>
            <button @click="logout">Logout</button>
          </div>
        </div>
    </div>
</template>

<script>
import NavBar from '../components/NavBar.vue';
import EventBus from '@/eventBus/eventBus';

import SidebarComponent from '@/components/Sidebar.vue';

export default {
  name: 'HomePage',
  components: {
    NavBar,
    SidebarComponent,
  },
  data() {
    return {
      userName: 'Admin',
      isDarkMode: localStorage.getItem('dark-mode') === 'true' || (window.matchMedia('(prefers-color-scheme: dark)').matches),
    };
  },
  mounted() {
    EventBus.on('toggle-dark-mode', (isDarkMode) => {
      this.isDarkMode = isDarkMode;
    });
  },
  methods: {
    logout() {
      localStorage.removeItem('auth');
      this.$router.push('/');
    },
  },
};
</script>
<style scoped>
  .home-page {
    display: flex;
    flex-direction: column;
    transition: background-color 0.3s;
    height: 100vh;
}
.home-page.dark-mode {
  background-color: #192229;
  color: #a0a7ac;
}

.home-page:not(.dark-mode) {
  background-color: white;
  color: black;
}
.main-content {
  display: flex;
  flex: 1;
}
.sidebar {
  width: 200px;
  transition: background-color 0.3s;
}
.content {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
button {
  margin-top: 20px;
  padding: 10px 20px;
  cursor: pointer;
}
</style>