<template>
  <v-btn color="primary" @click="goToCuentasEstadoCuentaColones"> Consultar Estado ₡</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToCuentasEstadoCuentaColones = () => {
  router.push('/estado-cuenta-colones')
}
</script>

<style scoped></style>
