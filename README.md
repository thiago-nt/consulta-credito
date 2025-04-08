# FrontEnd
This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 19.2.6.

npm run start 
http://localhost:4200/

Estrutura definida do front-end
src/
├── app/
│   ├── services/
│   │   └── credito.service.ts       # Responsável pelas chamadas HTTP
│   ├── models/
│   │   └── credito.model.ts         # Interfaces TypeScript
│   ├── components/
│   │   ├── lista-creditos/          # Tela para listar créditos por NFS-e
│   │   │   └── lista-creditos.component.ts/html/scss
│   │   └── detalhe-credito/         # Tela para mostrar detalhes de um crédito
│   │       └── detalhe-credito.component.ts/html/scss
│   ├── app-routing.module.ts        # Rotas
│   └── app.module.ts                # Módulo principal



Usando in-memory-web-api para simular mock da apis.

