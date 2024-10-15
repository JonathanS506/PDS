<template>
  <v-btn color="primary" @click="goToMenuConsultaCuentaYSaldo">
    Consultar Cuentas y saldos respectivos</v-btn
  >
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToMenuConsultaCuentaYSaldo = () => {
  router.push('/consultar-cte-saldo')
}
</script>

<style scoped></style>
