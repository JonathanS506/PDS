<template>
  <v-btn color="primary" @click="goToCambiarCorreo"> Cambiar correo</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToCambiarCorreo = () => {
  router.push('/cambiar-correo')
}
</script>

<style scoped></style>
