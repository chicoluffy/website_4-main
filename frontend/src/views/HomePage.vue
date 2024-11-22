<template>
    <div>
        <NavBar/>
        <h1>Welcome, {{ userName }}</h1>
        <button @click="logout">Logout</button>
    </div>
</template>

<script>
import NavBar from '../components/NavBar.vue';

export default {
  name: 'HomePage',
  components: {
    NavBar,
  },
  data() {
    return {
      userName: 'Admin',
    };
  },
  methods: {
    logout() {
      localStorage.removeItem('auth');
      this.$router.push('/');
    },
  },
};
</script>