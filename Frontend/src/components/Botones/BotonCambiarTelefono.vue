<template>
  <v-btn color="primary" @click="goToCambiarTelefono"> Cambiar Teléfono</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToCambiarTelefono = () => {
  router.push('/cambiar-telefono')
}
</script>

<style scoped></style>
