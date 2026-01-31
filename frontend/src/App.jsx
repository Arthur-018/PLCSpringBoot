import "./App.css";

const highlights = [
  {
    title: "Monitoramento em tempo real",
    description:
      "Acompanhe dados do PLC com atualizações instantâneas e alertas configuráveis."
  },
  {
    title: "Painéis personalizáveis",
    description:
      "Monte dashboards com indicadores, gráficos e status dos dispositivos."
  },
  {
    title: "Integração segura",
    description:
      "Conecte o backend Spring Boot com autenticação e trilhas de auditoria."
  }
];

const steps = [
  {
    step: "1",
    title: "Conecte",
    detail: "Configure a comunicação com o PLC e valide a conexão."
  },
  {
    step: "2",
    title: "Colete",
    detail: "Defina quais tags e métricas devem ser monitoradas."
  },
  {
    step: "3",
    title: "Aja",
    detail: "Receba insights e acione automações com segurança."
  }
];

export default function App() {
  return (
    <div className="app">
      <header className="hero">
        <div>
          <p className="eyebrow">PLC Spring Boot</p>
          <h1>Frontend em React para acompanhar seu parque industrial.</h1>
          <p className="subtitle">
            Uma base moderna em React + Vite para integrar com a API em Spring
            Boot e entregar visualização rápida, segura e responsiva.
          </p>
          <div className="actions">
            <button className="primary">Começar agora</button>
            <button className="ghost">Ver documentação</button>
          </div>
          <div className="stats">
            <div>
              <strong>24/7</strong>
              <span>Monitoramento</span>
            </div>
            <div>
              <strong>+120</strong>
              <span>Tags suportadas</span>
            </div>
            <div>
              <strong>99.9%</strong>
              <span>Uptime</span>
            </div>
          </div>
        </div>
        <div className="hero-card">
          <div className="card-header">
            <h2>Status da linha</h2>
            <span className="pill">Operacional</span>
          </div>
          <ul>
            <li>
              <span>Temperatura</span>
              <strong>68°C</strong>
            </li>
            <li>
              <span>Vibração</span>
              <strong>Normal</strong>
            </li>
            <li>
              <span>Produção</span>
              <strong>1.284 un/h</strong>
            </li>
          </ul>
          <div className="card-footer">
            <p>Última atualização: 2s</p>
            <button className="ghost small">Detalhar</button>
          </div>
        </div>
      </header>

      <section className="highlights">
        {highlights.map((item) => (
          <article key={item.title}>
            <h3>{item.title}</h3>
            <p>{item.description}</p>
          </article>
        ))}
      </section>

      <section className="steps">
        <div>
          <h2>Fluxo recomendado</h2>
          <p>
            Estruture o ciclo de dados do PLC em três passos para extrair valor
            rapidamente.
          </p>
        </div>
        <div className="step-grid">
          {steps.map((step) => (
            <div key={step.step} className="step-card">
              <span>{step.step}</span>
              <h3>{step.title}</h3>
              <p>{step.detail}</p>
            </div>
          ))}
        </div>
      </section>

      <section className="cta">
        <div>
          <h2>Pronto para integrar?</h2>
          <p>
            Este frontend já está pronto para consumir endpoints REST e WebSocket
            do seu backend Spring Boot.
          </p>
        </div>
        <button className="primary">Conectar API</button>
      </section>
    </div>
  );
}
