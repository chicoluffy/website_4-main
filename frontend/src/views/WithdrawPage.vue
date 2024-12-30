

<template>
    <div :class="['DepWithPage', {'dark-mode': isDarkMode}]">
        <h1>Withdraw</h1>
        <WithdrawTab/>
    </div>
</template>
<script>
import WithdrawTab from '@/components/WithdrawTab.vue';
export default {
    name: 'DepWithPage',
    components: {
        WithdrawTab,
    },
    props: {
        isDarkMode: {
            type: Boolean,
            default: false
        }
    },

}
</script>
<style scoped>
.DepWithPage{
    width: 100%;
    height: 100vh;
    display: flex;
    flex-direction: column;
    color: #333;
}
.DepWithPage.dark-mode{
    background-color: #2a3b47;
    color: #fff;
}
</style>