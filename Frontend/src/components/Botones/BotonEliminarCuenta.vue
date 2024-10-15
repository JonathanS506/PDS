<template>
  <v-btn color="primary" @click="goToEliminarCuenta"> Eliminar Cuenta</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToEliminarCuenta = () => {
  router.push('/eliminar-cuenta')
}
</script>

<style scoped></style>
