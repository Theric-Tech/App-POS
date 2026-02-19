# App-POS
Aplicação Android embarcada para POS.

---

## Branches principais

- **feature/*** → desenvolvimento de funcionalidades
- **dev** → integração contínua do time
- **release/*** → preparação de release
- **main** → produção (somente código versionado e estável)

---

## Fluxo de Desenvolvimento

1. **PO cria a story no Jira**
2. **Dev cria branch**
3. Desenvolvimento local
4. Pull Request → **dev**
5. CI #1 (Feature Validation) roda automaticamente
6. PR aprovado → merge em **dev**
7. CI #2 (DEV Integration) valida integração

---

## Processo de Release (Checklist Oficial)

### Pré-requisitos (antes de criar release)

- [ ] Código necessário para a release **já está em `dev`**
- [ ] Nenhuma feature incompleta bloqueando a release
- [ ] Features futuras **permanecem em PR aberto ou feature branch**
- [ ] `dev` está verde no CI
- [ ] Versionamento definido (versionCode / versionName)

---

### Criar Release Branch

```bash
git checkout dev
git pull
git checkout -b release/1.2.0
git push origin release/1.2.0
git tag v1.2.0
git push origin v1.2.0
git checkout main
git merge release/1.2.0
git push origin main


---
---
---
-=-
---
---
---
