<template>
  <v-btn color="primary" @click="goToCrearCuenta"> Crear Cuenta</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToCrearCuenta = () => {
  router.push('/crear-cuenta')
}
</script>

<style scoped></style>
