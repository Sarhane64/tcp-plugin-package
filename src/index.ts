import { registerPlugin } from '@capacitor/core';

import type { TcpSocketPluginPlugin } from './definitions';

const TcpSocketPlugin = registerPlugin<TcpSocketPluginPlugin>('TcpSocketPlugin', {
  web: () => import('./web').then((m) => new m.TcpSocketPluginWeb()),
});

export * from './definitions';
export { TcpSocketPlugin };
