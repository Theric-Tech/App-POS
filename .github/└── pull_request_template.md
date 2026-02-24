## 📌 O que foi feito
Descreva objetivamente o que mudou neste PR.
Evite termos genéricos como “ajustes” ou “melhorias”.

---

## 🔗 Jira
- Ticket: JIRA-XXX
- Link: https://seu-jira/browse/JIRA-XXX

---

##  Como testar
Descreva **passo a passo** como validar a mudança.

Exemplo:
1. Instalar APK gerado pelo CI
2. Inicializar o POS
3. Executar fluxo de pagamento (crédito / débito / PIX, se aplicável)
4. Validar resposta do backend
5. Validar logs e comportamento do hardware

---

## 💳 Impacto em Pagamento (OBRIGATÓRIO)

Marque uma opção:

- [ ] ❌ **Não impacta** fluxo de pagamento
- [ ] ⚠️ **Impacta indiretamente** (ex: UX, timeout, navegação)
- [ ] 🚨 **Impacta diretamente** (autorização, captura, cancelamento, conciliação)

Se impactar, descreva:
- tipo de transação
- cenário afetado
- risco conhecido

---

##  POS / Android Embarcado

- [ ] Não altera integração com hardware (pinpad, impressora, NFC)
- [ ] Não altera SDK do fornecedor do POS
- [ ] Compatível com versão do Android embarcado
- [ ] Não depende de serviços Google (GMS)

---

##  Segurança e Compliance

- [ ] Não loga dados sensíveis (PAN, senha, CVV, tokens)
- [ ] Não expõe chaves ou secrets no código
- [ ] Mantém criptografia exigida pelo fornecedor
- [ ] Atende requisitos contratuais / certificação

---

##  Checklist Técnico

- [ ] PR criado para a branch correta
- [ ] CI passou com sucesso
- [ ] Código segue padrão do projeto
- [ ] Sem commits de debug
- [ ] Sem código comentado desnecessário

---

##  Riscos e Observações
Descreva riscos conhecidos ou pontos de atenção.

Se **não houver riscos**, escrever:
> Sem riscos conhecidos.

---

## Evidências (se aplicável)
- Prints
- Logs
- Vídeo curto
- Número da versão testada
