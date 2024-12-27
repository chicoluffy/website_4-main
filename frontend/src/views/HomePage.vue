<template>
    <div :class= "['home-page',{'dark-mode':isDarkMode}]">
      <div class="content">
        <h1>Welcome, {{ userName }}</h1>
        <ul>
          <li v-for="privilege in privileges" :key="privilege">
            {{ privilege }}
          </li>
        </ul>
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
      privileges: []
    };
  },
  mounted(){
    const privileges = localStorage.getItem('privileges');
    if(privileges){
      this.privileges = JSON.parse(privileges);
    }
  }
};
</script>
<style scoped>
  .home-page {
    display: flex;
    flex-direction: column;
    transition: background-color 0.3s;
    height: 100vh;
    width: 100%;
}
.home-page.dark-mode {
  background-color: #192229;
  color: #a0a7ac;
}

.home-page:not(.dark-mode) {
  background-color: white;
  color: black;
}
</style>