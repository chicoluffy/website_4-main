<template>
    <div :class="['division-page',{'dark-mode':IsDarkMode}]">
        <div class="header">
      <SwitchBtn :is-dark-mode="IsDarkMode" class="switch-btn" />
    </div>
    <div class="content">
      <SelectDivision :is-dark-mode="IsDarkMode" class="select-division" />
    </div>
    </div>
</template>

<script>
import SelectDivision from '@/components/SelectDivision.vue';
import SwitchBtn from '@/components/SwitchBtn.vue';
import EventBus from '@/eventBus/eventBus';

 export default {
     name: 'DivisionPage',
     components: {
            SwitchBtn,
            SelectDivision,
     },
     data(){
         return {
             IsDarkMode: localStorage.getItem('dark-mode') === 'true' || (window.matchMedia('(prefers-color-scheme: dark)').matches)
         };
     },
     mounted(){
         EventBus.on('toggle-dark-mode', (isDarkMode) => {
             this.IsDarkMode = isDarkMode;
         });
     },
 };
</script>
<style>
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
.division-page {
    display: flex;
    flex-direction: column;
    justify-content: flex-start; /* Asegura que los hijos no se superpongan */
    align-items: center;
    height: 100vh;
    width: 100%; /* Asegura que ocupe todo el ancho */
    position: relative;
    transition: background-color 0.3s;
}
.division-page.dark-mode {
    background-color: #192229;
    color: #52A5E0;
}
.division-page:not(.dark-mode){
    background-color: #FBFBFE;
    color: #2A3B47;
}
.switch-btn {
  position: absolute;
  top: 20px;
  right: 20px;
}
.select-division {
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>