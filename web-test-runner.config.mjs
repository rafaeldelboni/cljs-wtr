import { puppeteerLauncher } from '@web/test-runner-puppeteer';

export default {
  debug: false,
  nodeResolve: true,
  browsers: [
    puppeteerLauncher({
      launchOptions: {
        // headless: false,
        // slowMo: 2500,
        devtools: true,
        args: ['--no-sandbox'],
      },
    }),
  ],
};
