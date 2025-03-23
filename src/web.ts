import { PluginListenerHandle, WebPlugin } from '@capacitor/core';
import type { TcpSocketPluginPlugin } from './definitions';

export class TcpSocketPluginWeb extends WebPlugin implements TcpSocketPluginPlugin {
  async connect(): Promise<void> {
    console.warn('TcpSocketPlugin: Web platform does not support sockets.');
  }

  async send(): Promise<void> {
    console.warn('TcpSocketPlugin: Web platform does not support sockets.');
  }

  async close(): Promise<void> {
    console.warn('TcpSocketPlugin: Web platform does not support sockets.');
  }
  addListener(eventName: string, listenerFunc: any): Promise<PluginListenerHandle> {
    console.warn(`TcpSocketPlugin: addListener(${eventName}) is not supported on Web.`);
    return super.addListener(eventName, listenerFunc);
  }
}
