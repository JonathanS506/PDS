<template>
  <v-btn color="primary" @click="goToCuentasEstadoCuentaDolares"> Consultar Estado $</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToCuentasEstadoCuentaDolares = () => {
  router.push('/estado-cuenta-dolares')
}
</script>

<style scoped></style>
