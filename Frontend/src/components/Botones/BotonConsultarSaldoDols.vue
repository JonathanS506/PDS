<template>
  <v-btn color="primary" @click="goToMenuConsultaSaldoDols"> Consultar saldo $</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToMenuConsultaSaldoDols = () => {
  router.push('/consulta-saldo-dolares')
}
</script>

<style scoped></style>
