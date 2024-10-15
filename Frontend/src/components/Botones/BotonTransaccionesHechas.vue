<template>
  <v-btn color="primary" @click="goToTransaccionesHechas"> Transacciones hechas </v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToTransaccionesHechas = () => {
  router.push('/consultar-transacciones')
}
</script>

<style scoped></style>
