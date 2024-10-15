<template>
  <v-btn color="primary" @click="goToDepositoDols"> Deposito $</v-btn>
</template>

<script setup>
import { useRouter } from 'vue-router'

const router = useRouter()

const goToDepositoDols = () => {
  router.push('/realizar-deposito-dolares')
}
</script>

<style scoped></style>
