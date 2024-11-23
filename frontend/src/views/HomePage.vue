<template>
    <div :class= "['home-page',{'dark-mode':isDarkMode}]">
      <div class="content">
        <h1>Welcome, {{ userName }}</h1>
      </div>
    </div>
</template>

<script>
export default {
  name: 'HomePage',
  props:{
    isDarkMode:{
      type:Boolean,
      required:true
    }
  },
  data() {
    return {
      userName: 'Admin',
    };
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
</style>