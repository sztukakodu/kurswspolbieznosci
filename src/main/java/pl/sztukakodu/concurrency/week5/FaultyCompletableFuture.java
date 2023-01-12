package pl.sztukakodu.concurrency.week5;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static pl.sztukakodu.concurrency.ThreadUtils.println;

class FaultyCompletableFuture {

    public static void main(String[] args) throws Exception {
        println("Starting...");
        CompletableFuture<String> klockiAsync = new AsyncTask("klocki").fetch();
        CompletableFuture<String> tasmaAsync = new AsyncTask("tasma").fetch();
        CompletableFuture<String> papierAsync = new AsyncTask("papier").fetch();

        final CompletableFuture<List<String>> future = klockiAsync.thenCombine(tasmaAsync, (klocki, tasma) -> {
            List<String> lista = new ArrayList<>();
            lista.add(klocki);
            lista.add(tasma);
            return lista;
        }).thenCombine(papierAsync, (lista, papier) -> {
            lista.add(papier);
            return lista;
        }).whenComplete((lista, error) -> {
            if (error != null) {
                System.err.println("Something went wrong. Unable to proceed with your order");
            } else {
                println("Parcel: [" + String.join(", ", lista) + "]");
            }
        });
        future.get();
        println("DONE");
    }

    static class AsyncTask {
        private final SecureRandom random = new SecureRandom();
        private final String result;

        public AsyncTask(String result) {
            this.result = result;
        }

        public CompletableFuture<String> fetch() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    println("Preparing result: " + result + "...");
                    if (random.nextBoolean()) {
                        throw new RuntimeException("Oops! Can't prepare result of " + result + "!");
                    }
                    Thread.sleep(500);
                    println("DONE [" + result + "]");
                    return result;
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            });
        }
    }
}
