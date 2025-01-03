<template>
    <div :class="['AutomaticDepositPage', {'dark-mode': isDarkMode}]">
        <div class="AutomaticDepositPage">
            <AutomaticDep :isDarkMode="isDarkMode"/>
        </div>
    </div>
</template>

<script>
import AutomaticDep from '@/components/AutomaticDep.vue';
export default {
    name: 'AutomaticDepositPage',
    props: {
        isDarkMode: {
            type: Boolean,
            default: false
        }
    },
    components: {
        AutomaticDep
    }
}
</script>
<style scoped>
.AutomaticDepositPage{
    width: 100%;
    height: 100vh;
    display: flex;
    flex-direction: column;
    color: #333;
}
.AutomaticDepositPage.dark-mode{
    background-color: #121212;
    color: #fff;
}


</style>