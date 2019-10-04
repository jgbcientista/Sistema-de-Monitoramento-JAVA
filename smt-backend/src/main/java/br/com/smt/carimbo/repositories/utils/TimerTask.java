package br.com.smt.carimbo.repositories.utils;


public abstract class TimerTask implements Runnable {
	
	final Object lock = new Object();
    int state = VIRGIN;
    static final int VIRGIN = 0;
    static final int SCHEDULED   = 1;
    static final int EXECUTED    = 2;
    static final int CANCELLED   = 3;
    long nextExecutionTime;
    long period = 0;
  
    protected TimerTask() {
    }
  
    public abstract void run();
  
    public boolean cancel() {
        synchronized(lock) {
            boolean result = (state == SCHEDULED);
            state = CANCELLED;
            return result;
        }
    }
  
    public long scheduledExecutionTime() {
        synchronized(lock) {
            return (period < 0 ? nextExecutionTime + period
                               : nextExecutionTime - period);
        }
    }
}
//O método que nos interessa na listagem acima é o “public abstract void run()”, ele será o responsável por executa nossa lógica em intervalos pré-configurados. Como você já deve ter notado o princípio para uso da classe TimeTask é estendê-la e implementar o método run(), já que este é abstrato e sua implementação é obrigatória. Então é exatamente isso que faremos, como mostra a Listagem 2.
