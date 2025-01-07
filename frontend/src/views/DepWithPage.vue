<template>
    <div :class="['container', {'dark-mode': isDarkMode}]">
        <div class="row">
            <div class="col">
                <h1>Deposit</h1>
            </div>
            <div class="col">
                <form class="form-inline d-flex gap-2">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </div>
        <DepositTab />
       
    </div>
</template>

<script>
import DepositTab from '@/components/DepositTab.vue';


export default {
    name : 'DepWithPage',
    components: {
        DepositTab,
    },
    props: {
        isDarkMode: {
            type: Boolean,
            default: false
        }
    },
}
</script>
