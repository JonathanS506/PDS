<template>
  <v-btn color="primary" @click="goToDepositoCols"> Deposito ₡</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToDepositoCols = () => {
  router.push('/realizar-deposito-colones')
}
</script>

<style scoped></style>
