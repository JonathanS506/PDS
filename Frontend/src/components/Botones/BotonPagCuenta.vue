<template>
  <v-btn color="primary" @click="goToMenuCuentas"> Cuentas</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToMenuCuentas = () => {
  router.push('/menu-cuentas')
}
</script>

<style scoped></style>
