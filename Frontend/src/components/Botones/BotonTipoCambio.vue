<template>
  <v-btn color="primary" @click="goToTipoCambio"> Tipo de Cambio</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToTipoCambio = () => {
  router.push('/informacion-tipo-de-cambio')
}
</script>

<style scoped></style>
