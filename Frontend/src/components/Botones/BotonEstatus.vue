<template>
  <v-btn color="primary" @click="goToEstatus"> Estatus de Cuenta</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToEstatus = () => {
  router.push('/consultar-estatus')
}
</script>

<style scoped></style>
