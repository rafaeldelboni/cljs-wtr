# cljs-wtr
Playground combining wtr with cljs

### wtr
```bash
rm -rf out/wtr
npx shadow-cljs compile wtr
npx web-test-runner out/wtr/**/*-test.js --node-resolve --debug
```
### wtr2 
```bash
rm -rf out/wtr2
npx shadow-cljs compile wtr2
npx web-test-runner out/wtr2/main.js --node-resolve --debug
```
