<template>
  <v-btn color="primary" @click="goToMenuConsultaSaldoCols"> Consultar saldo ₡</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToMenuConsultaSaldoCols = () => {
  router.push('/consulta-saldo-colones')
}
</script>

<style scoped></style>
