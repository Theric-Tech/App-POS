# 📦 CI/CD Pipeline — App POS

Este documento descreve o funcionamento do pipeline de **Integração Contínua (CI)** e **Entrega Contínua (CD)** do projeto.

---

# 🧭 Visão Geral

O fluxo segue uma abordagem baseada em **Git Flow simplificado**, com separação clara entre:

* **Feature development**
* **Integração (dev)**
* **Estabilização (release)**
* **Produção (main)**

---

# 🔄 Fluxo de Branches

```text
feature/* → dev → release/* → main
```

---

# 🔵 CI — Integração Contínua

## 1. CI Feature — Validação de Features

**Arquivo:** `ci-feature.yml`

### 📌 Disparo

* Push em `feature/*`

### ✅ Validações

* Setup do ambiente Android
* Validação do Gradle Wrapper
* Build do APK Debug

### 🎯 Objetivo

Garantir que cada feature:

* compila corretamente
* não quebra o build

---

## 2. CI DEV — Integração

**Arquivo:** `ci-dev.yml`

### 📌 Disparo

* Pull Request → `dev`
* (opcional) Push em `dev`

---

### 🔹 Validação de origem do PR

* Apenas `feature/*` pode ir para `dev`

❌ Bloqueia:

* hotfix direto
* commits fora do fluxo

---

### 🔹 Build de integração

* Build APK Debug
* Geração de artifact

### 🎯 Objetivo

Garantir que:

* múltiplas features funcionam juntas
* integração não quebra o app

---

## 3. CI PR Release — Controle de Release

**Arquivo:** `ci-pr-release.yml`

### 📌 Disparo

* PR → `release/*`

---

### 🔹 Validação

* Apenas `fix/*` pode entrar em `release/*`

### 🎯 Objetivo

Garantir que:

* release recebe apenas correções
* escopo da release não cresce indevidamente

---

### 🔹 Sync automático

Após merge:

* cria PR automático de `release/* → dev`

### 🎯 Benefício

* mantém ambientes sincronizados
* evita retrabalho manual

---

## 4. CI Main — Validação Final

**Arquivo:** `ci-main.yml`

### 📌 Disparo

* PR → `main`
* Push em `main`

---

### ✅ Validações

* Testes unitários
* Lint
* Build Release

---

### 🔹 Regra de governança

* Apenas `release/*` pode ir para `main`

### 🎯 Objetivo

Garantir que:

* somente código estabilizado chegue em produção

---

# 🟣 CD — Entrega Contínua

## 5. Build Artifact — Release Candidate (RC)

**Arquivo:** `build-artifact.yml`

### 📌 Disparo

* Push em `release/*`
* Execução manual
* Reuso via `workflow_call`

---

### 🔹 Versionamento automático

A partir da branch:

```
release/1.2 → 1.2.0-rcX
```

Inclui:

* versionName (semântico)
* versionCode (incremental)
* commit SHA

---

### 🔹 Build

* Build APK Release
* Renomeação com versão + SHA

---

### 🔹 Publicação

* Upload como artifact
* Criação de release no GitHub:

  * draft
  * prerelease (RC)

---

### 🎯 Objetivo

Gerar builds:

* rastreáveis
* testáveis
* versionados automaticamente

---

## 6. Promoção de Release

**Arquivo:** `ci-tag-main.yml`

### 📌 Disparo

* Criação de tag (`v*`)

---

### 🔹 Ações

* Localiza último RC (draft)
* Promove para release oficial:

  * remove `draft`
  * remove `prerelease`
  * aplica tag final

---

### 🎯 Objetivo

Publicar versão oficial:

* sem rebuild
* garantindo rastreabilidade

---

# 🟡 Criação de Release

## 7. Create Release Branch

**Arquivo:** `ci-create-release.yml`

### 📌 Disparo

* Manual (`workflow_dispatch`)

---

### 🔹 Validações

* Versão deve ser informada corretamente (ex: `1.2`)
* Branch não pode já existir

---

### 🔹 Ações

* Cria `release/X.Y` a partir de `dev`
* Publica a branch

---

### 🎯 Objetivo

Padronizar e evitar erros humanos na criação de releases

---

# 🧠 Resumo do Processo

```text
1. Dev cria feature
2. Feature validada (CI Feature)
3. PR para dev (CI DEV)
4. Release criada manualmente
5. Correções via fix/*
6. PR para release (CI PR Release)
7. Build automático gera RC
8. QA valida RC
9. Tag promove para produção
10. PR release → main (validação final)
```

---

# ✅ Benefícios do Pipeline

* 🔒 Controle rigoroso de origem de código
* 🔁 Sincronização automática entre ambientes
* 📦 Builds versionados automaticamente
* 🚫 Zero deploy manual inseguro
* 🔍 Rastreabilidade completa (branch + commit + versão)
* ⚡ Sem rebuild na promoção para produção

---

# 🏁 Conclusão

Este pipeline garante:

* qualidade contínua (CI)
* previsibilidade de releases
* segurança na promoção para produção (CD)

---

Se houver dúvidas ou necessidade de evolução do pipeline, documentar as mudanças neste arquivo.
