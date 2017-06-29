package javabanco.entidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class ContaCorrenteTest{
		
		@Test
		public void testCriacaoObjeto() {
			ContaCorrente cc = new ContaCorrente(54321, "marcio souza");
			assertNotNull (cc);
		}
		
		@Test
		public void testSaldo() {
			ContaCorrente cc= new ContaCorrente(54321, "marcio souza");
			assertEquals(0, cc.saldo(), 0);
		}
		
		@Test
		public void testCredito() {
			ContaCorrente cc = new ContaCorrente(54321, "marcio souza");
			cc.credito(100);
			assertEquals(100, cc.saldo(), 0);
		}
		
		@Test
		public void testDebito() {
			ContaCorrente cc = new ContaCorrente(54321, "marcio souza");
			cc.debito(100);
			assertEquals(-100, cc.saldo(), 0);
		}
		
		@Test
		public void testSaldosPequenosFloats() {
			ContaCorrente cc = new ContaCorrente(54321, "marcio souza");
			cc.credito(0.1f);
			cc.credito(0.2f);
			assertEquals(0.3f, cc.saldo(), 0.0f);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testCreditoValorNegativo() {
			ContaCorrente cc = new ContaCorrente(54321, "marcio souza");
			
			cc.credito(-10);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testDebitoValorNegativo() {
			ContaCorrente cc = new ContaCorrente(54321, "marcio souza");
			
			cc.debito(-10);
		}
		
		@Test
		public void testGetTitular() {
			ContaCorrente cc = new ContaCorrente(54321, "marcio souza");
			assertEquals("marcio souza", cc.getTitular());
		}
		
		@Test
		public void testGetNumero() {
			ContaCorrente cc = new ContaCorrente(54321, "marcio souza");
			assertEquals(54321, cc.getNumero(), 0);
		}
		
		@Test
		public void testExtrato() {
			ContaCorrente cc = new ContaCorrente(12345, "marcio souza");
			cc.credito(100); 
			cc.debito(100);
			ArrayList<Operacao> listaOperacoes = cc.extrato();
			assertEquals(2, listaOperacoes.size());
			Operacao op1 = listaOperacoes.get(0);
			assertEquals(100, op1.getValor(),0);
			assertEquals("CREDITO", op1.getTipoOperacao());
			assertEquals(80, listaOperacoes.get(1).getValor(), 0);
			assertEquals("DEBITO", listaOperacoes.get(1).getTipoOperacao());
		}
		
	}