<template>
  <div>
    <RealizarDepositoFormulario @realizarDepositoSuccess="handleSuccess" />
  </div>
</template>

<script setup>
import RealizarDepositoFormulario from '@/components/DepositoColonesFormulario.vue';
</script>

<style scoped></style>
