<template>
  <v-btn color="primary" @click="goToTransferencias"> Transferencia </v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToTransferencias = () => {
  router.push('/realizar-transferencia')
}
</script>

<style scoped></style>
