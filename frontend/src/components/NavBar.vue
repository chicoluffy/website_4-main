<template>
    <nav :class="{'dark-mode':isDarkMode}">
      <div class="nav-content">
        <ul>
          <li><a href="/home">Home</a></li>
          <li><a href="/Profile">Profile</a></li>
        </ul>
        <div class="time">
          <p>Local Time: {{ localTime }}</p>
          <p>UTC Time: {{ utcTime }}</p>
        </div>
        <div>
          <LogoutBtn/>
          <SwitchBtn :isDarkMode="isDarkMode"/>
        </div>
    </div>
    </nav>
</template>
<script>
  import SwitchBtn from '@/components/SwitchBtn.vue';
  import LogoutBtn from './LogoutBtn.vue';
  export default {

    name: 'NavBar',
    components: {
      SwitchBtn,
      LogoutBtn
    },
    props: {
      isDarkMode: {
        type: Boolean,
        required: true
      }
    },
    data(){
      return {
        localTime: '',
        utcTime: ''
      };
    },
    mounted(){
      this.updateTime();
      setInterval(this.updateTime, 1000);
    },
    methods: {
      updateTime(){
        const now = new Date();
        this.localTime = now.toLocaleTimeString();
        this.utcTime = now.toUTCString().split(' ')[4];
      }
    }
  }
</script>
<style scoped>
nav {
  transition: background-color 0.3s;
  padding: 10px;
}
.nav-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
}
nav.dark-mode {
  background-color: #212E36;
  color: #A0A7AC;
}
nav:not(.dark-mode) {
  background-color: #1083D6;
  color: #2A3B47;
}
ul {
  display: flex;
  list-style: none;
  justify-content: start;
  gap: 20px;
}
nav.dark-mode li a {
  color: #52A5E0;
  text-decoration: none;
}
nav:not(.dark-mode) li a{
  color: #2A3B47;
  text-decoration: none;
}
.time {
  margin-top: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px; /* Optional: Adds space between the time elements */
}

.time p {
  margin: 0;
}
</style>